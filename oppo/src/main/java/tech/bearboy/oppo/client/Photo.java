
package tech.bearboy.oppo.client;
/**
 * <p>��ʾͼƬ��bean��  </p>
 * <p>��Ŀ����: oppo </p> 
 * <p>�ļ�����: Photo.java </p> 
 * <p>����ʱ��: 2019��3��4�� </p>
 * @author ��ǰǰ
 * @version v1.0
 */
public class Photo {
	/**
	 * ͼƬurl
	 */
	String imgUrl;//ͼƬurl
	/**
	 * ͼƬʶ������������Ϣ
	 */
	String msg;//ͼƬʶ������������Ϣ
	/**
	 * ʱ��
	 */
	String time;//ʱ��
	/**
	 * �ص�
	 */
	String location;//�ص�
	/**
	 * �ı������
	 */
	String text;//�ı������
	/**
	 * Ŀ������
	 */
	String target;//Ŀ������

	public void setImgUrl(String url) {
		this.imgUrl = url;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return this.time;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return this.location;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTarget() {
		return this.target;
	}
}
