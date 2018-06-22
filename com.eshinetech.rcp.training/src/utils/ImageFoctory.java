package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
/**
 * @author cr.wu
 * */
public class ImageFoctory {
	
	public static Hashtable<String, ImageData> hm = new Hashtable<String, ImageData>();
	/**
	 * 读取图片，并设置size
	 * */
	public static Image getImg(Display d,String path,int width,int height){
//		path = "G:/swtSpace/justTest/img/clear.gif";
		ImageData data = hm.get(path);
		if(data == null){
			File file = new File(path);
			Image image ;
			if(path.contains("http")){
				image = getNetJPG(path);
			}else{
				if(!file.exists()){
					return null;
//					return getImg(ImagePath.IMAGEERROR);
				}
				image = new Image(d, path);
			}
			
			data = image.getImageData();
			hm.put(path, data);
		}
		Image image  = new Image(d, data);
		return setSize(image,width,height);
	}
	public static Image getImg(String path,int width,int height){
		return getImg(Display.getCurrent(), path,width,height);
	}
	
	public static Image getImg(String path){
		return getImg( path,-1,-1);
//		return new Image(Main.getDisplay(), path);
	}
	
	public static Image getImgByRoot(String path){
	    return getImg(System.getProperty("user.dir") + File.separatorChar+""+path);
	}
	
	/**
	 * 设置图片的大小
	 * */
	public static Image setSize(Image image ,int width,int height){
		if(width == -1&&height == -1){
			return image;
		}
		if(height == -1){
			height = image.getImageData().height;
		}
		if(width == -1){
			width = image.getImageData().width;
		}
		Image imageNew = new Image(Display.getDefault(), width, height);
		GC gc = new GC(imageNew); 
		gc.drawImage(image, 0, 0, image.getImageData().width, image.getImageData().height, 0, 0, width, height);
		gc.dispose();
		
	
		image.dispose();//原图片资源释放
		return imageNew;
	}
	
	public static Display display(){
		return null;
	}
	/**
	 * 获取网络上的图片
	 * */
	public static Image getNetJPG(String u){
		InputStream in = getJPGStream(u);
		Image image = new Image(display(), in);
		return image;
	}
	/**
	 * 获取jpg的流
	 * */
	public static InputStream getJPGStream(String u){
		URL url;
		InputStream inStream = null;
		try {
			url = new URL(u);
			// 打开链接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置请求方式为"GET"
			conn.setRequestMethod("GET");
			// 超时响应时间为5秒
			conn.setConnectTimeout(5 * 1000);
			// 通过输入流获取图片数据
			inStream = conn.getInputStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inStream;
	}
	/**
	 * 将流保存成图片，存到本地
	 * */
	public static void inputToNative(InputStream in ,String savePath){
		int format = checkPicFormat(savePath);
		ImageData data = null;
		Image image = new Image(display(), in);
		data = image.getImageData();
		image.dispose();
		
//		try {
////			in.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		ImageLoader l = new ImageLoader();
		l.data = new ImageData[]{data};
		l.save(savePath, format);
		data = null;
	}
	/**
	 * 将网络图片存到本地
	 * */
	public static void netToNative(String netPath,String savePath,int[] size,int format){
		if(format == 0){
			format = checkPicFormat(netPath);
		}
		ImageData data = null;
		if(hm.get(netPath) == null){
			InputStream in = getJPGStream(netPath);
			Image image = new Image(display(), in);
			data = image.getImageData();
			image.dispose();
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			hm.put(netPath, data);
		}else{
			data = hm.get(netPath);
		}
		if(size!=null){
			int width = data.width;
			int height = data.height;
			if(size[0] == 0){
				size[0] = width;
			}
			if(size[1] == 1){
				size[1] = height;
			}
			data = data.scaledTo(size[0], size[1]);
		}
		ImageLoader l = new ImageLoader();
		l.data = new ImageData[]{data};
		l.save(savePath, format);
		
		
	}
	/**
	 * 检测格式
	 * */
	public static int checkPicFormat(String path){
		if(path.length() == 0)return 0;
		int format = 0;
		String[] t = path.split("\\.");
		String formatStr = t[t.length - 1];
		if("jpeg".equals(formatStr)){
			format = SWT.IMAGE_JPEG;
		}else if("jpg".equals(formatStr)){
			format = SWT.IMAGE_JPEG;
		}else if("png".equals(formatStr)){
			format = SWT.IMAGE_PNG;
		}else if("bmp".equals(formatStr)){
			format = SWT.IMAGE_BMP;
		}else if("gif".equals(formatStr)){
			format = SWT.IMAGE_GIF;
		}else if("icon".equals(formatStr)){
			format = SWT.IMAGE_ICO;
		}
		return format;
	}
	
	
	public static void main(String[] args) {
		String netPath = "http://imgsrc.baidu.com/forum/w%3D580/sign=7ca61064472309f7e76fad1a420c0c39/4eb24a2442a7d933fb79e183ac4bd11372f00169.jpg";
		//http://imgsrc.baidu.com/forum/w%3D580/sign=7ca61064472309f7e76fad1a420c0c39/4eb24a2442a7d933fb79e183ac4bd11372f00169.jpg
		InputStream in = getJPGStream(netPath);
		String path = System.getProperty("user.dir") + File.separatorChar+"checkCode"+ File.separatorChar+"t.jpg"+"";
		inputToNative(in, path);
		try {
			in = new FileInputStream(path);
			inputToNative(in, System.getProperty("user.dir") + File.separatorChar+"checkCode"+ File.separatorChar+"t2.jpg");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		};
	}
	
}

