
package tech.bearboy.oppo.common;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tech.bearboy.oppo.client.Photo;
/**
 * <p>ͨ�÷����� </p>
 * <p>��Ŀ����: oppo </p> 
 * <p>�ļ�����: Common.java </p> 
 * <p>����ʱ��: 2019��3��4�� </p>
 * @author ��ǰǰ
 * @version v1.0
 */
public class Common {

	/**
	 * list����תjson�ַ���
	 * @param list ����Photo����ļ���
	 * @return ��������Photo�����json�ַ���
	 */
	public String listToJSON(List<Photo> list) {
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}
	
	/**
	 * json�ַ���ת����
	 * @param jsonStr ����json�ַ���
	 * @return ���ض���
	 */
	public JSONObject jsonToObject(String jsonStr){
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		return jsonObject;
	}
	/**
	 * bean����תjson�ַ���
	 * @param p ����һ��ͼƬ
	 * @return ����json�ַ���
	 */
	public String beanToJSON(Photo p) {
		JSONObject jsonObject = JSONObject.fromObject(p);
		return jsonObject.toString();
	}

}
