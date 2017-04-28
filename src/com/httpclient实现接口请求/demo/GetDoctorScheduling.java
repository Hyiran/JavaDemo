package com.httpclientʵ�ֽӿ�����.demo;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class GetDoctorScheduling {

	// �ӿڵ�ַ
	private static String apiURL = "http://v3patientapi.hk515.com/patientapi/doctor/queryDoctors";
	private Log logger = LogFactory.getLog(this.getClass());
	private static final String pattern = "yyyy-MM-dd HH:mm:ss:SSS";
	private HttpClient httpClient = null;
	private HttpPost method = null;
	private long startTime = 0L;
	private long endTime = 0L;
	private int status = 0;

	/**
	 * �ӿڵ�ַ
	 * 
	 * @param url
	 */
	public GetDoctorScheduling(String url) {

		if (url != null) {
			this.apiURL = url;
		}
		if (apiURL != null) {
			httpClient = new DefaultHttpClient();
			method = new HttpPost(apiURL);
		}
	}

	/**
	 * ���� API
	 * 
	 * @param parameters
	 * @return
	 */
	public String post(String parameters) {
		String body = null;
		logger.info("parameters:" + parameters);

		if (method != null & parameters != null
				&& !"".equals(parameters.trim())) {
			try {

				// ����һ��NameValuePair���飬���ڴ洢�����͵Ĳ���
				method.addHeader("Content-type",
						"application/json; charset=utf-8");
				method.setHeader("Accept", "application/json");
				method.setEntity(new StringEntity(parameters, Charset
						.forName("UTF-8")));
				startTime = System.currentTimeMillis();

				HttpResponse response = httpClient.execute(method);

				endTime = System.currentTimeMillis();
				int statusCode = response.getStatusLine().getStatusCode();

				logger.info("statusCode:" + statusCode);
				logger.info("����API ����ʱ��(��λ������)��" + (endTime - startTime));
				if (statusCode != HttpStatus.SC_OK) {
					logger.error("Method failed:" + response.getStatusLine());
					status = 1;
				}

				// Read the response body
				body = EntityUtils.toString(response.getEntity());

			} catch (IOException e) {
				// �������
				status = 3;
			} finally {
				logger.info("���ýӿ�״̬��" + status);
			}

		}
		return body;
	}

	/**
	 * �������ص�json���ݣ���ȡҽ���Ű����ݣ������к�Դ��ҽ���б�
	 * hospitalId-ҽԺID
	 * deparmentId-����ID
	 * count-��ȡ����
	 */
	public String GetDoctorSchedule(String hospitalId,String deparmentId,int count) throws Exception {
		ArrayList<String> doctorIdList = new ArrayList<String>();

		GetDoctorScheduling ac = new GetDoctorScheduling(apiURL);
		JsonObject param = new JsonObject();
		param.addProperty("hospitalDepartmentId", deparmentId);
		param.addProperty("cityId", "");
		param.addProperty("doctorType", 2);
		param.addProperty("startIndex", 0);
		param.addProperty("pageSize", count);
		param.addProperty("isHaveSchedulingOnly", false);
		param.addProperty("hospitalId", hospitalId);
		param.addProperty("orderBy", 0);
		String result = ac.post(param.toString());
		
		JSONObject json = new JSONObject(result);
		json = (JSONObject) json.get("data");
		// System.out.println(json.toString());
		JSONArray JsonArray = (JSONArray) json.get("appointmentDoctorEs"); // �õ����е�ҽ���Ű�����

//		System.out.println(JsonArray.toString());
		for (int i = 0; i < JsonArray.length(); i++) {// ѭ����������ҽ�����Ű�����
			String Info = "";
			String name = "";
			String departmentName = "";
			String doctorId = "";
			String date = "";
			String num = "";
			
			JSONObject Doctor = (JSONObject) JsonArray.get(i); // ��ȡ����ҽ�����Ű�����
			
			name = Doctor.getString("doctorName"); // ҽ������
			departmentName = Doctor.getString("departmentName"); // ��������
			doctorId = Doctor.getString("appointmentDoctorId"); // ҽ��ID
			
			JSONArray schedue = Doctor.getJSONArray("schedulingList"); // �Ű���Ϣ
			for (int j = 0; j < schedue.length(); j++) {
				JSONObject tmp = (JSONObject) schedue.get(j);
				doctorIdList.add(doctorId);
				date += String.format("%s %s���� %s ",
						tmp.getString("schedulingDate"),
						tmp.getString("schedulingCount"), " ");
			}
			Info = String.format("ҽ��ID�� %s %s %s %s %s ", doctorId,
					departmentName, name, date, num);
			System.out.println(Info);
		}
		return doctorIdList.get(new Random().nextInt(doctorIdList.size())); // ����һ�����ҽ��ID
	}
	
	

	public static void main(String[] args) throws Exception {
		GetDoctorScheduling ac = new GetDoctorScheduling(apiURL);
		ac.GetDoctorSchedule("588233786081144832","",20);
	}

	/**
	 * 0.�ɹ� 1.ִ�з���ʧ�� 2.Э����� 3.�������
	 * 
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}
}