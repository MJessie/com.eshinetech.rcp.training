package com.eshinetech.training.jface.treeviewer.provider;

import java.util.List;

import org.eclipse.swt.graphics.Image;

public interface ITreeFace {
	/**显示的字符串
	 * @return
	 */
	public String getName();
    /**设置显示字符串
     * @param name
     */
    public void setName(String name);
    /**设置子tree列表
     * @param Children
     */
    public void setChildren(List Children);
    /**获取子tree列表
     * @return
     */
    public List getChildren();
    /**获取id
     * @return
     */
    public int getId();
    /**设置图片
     * @return
     */
    public Image getImg();
}
