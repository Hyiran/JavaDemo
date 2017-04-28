package com.httpclient实现接口请求.demo;
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

	// 接口地址
	private static String apiURL = "http://v3patientapi.hk515.com/patientapi/doctor/queryDoctors";
	private Log logger = LogFactory.getLog(this.getClass());
	private static final String pattern = "yyyy-MM-dd HH:mm:ss:SSS";
	private HttpClient httpClient = null;
	private HttpPost method = null;
	private long startTime = 0L;
	private long endTime = 0L;
	private int status = 0;

	/**
	 * 接口地址
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
	 * 调用 API
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

				// 建立一个NameValuePair数组，用于存储欲传送的参数
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
				logger.info("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
				if (statusCode != HttpStatus.SC_OK) {
					logger.error("Method failed:" + response.getStatusLine());
					status = 1;
				}

				// Read the response body
				body = EntityUtils.toString(response.getEntity());

			} catch (IOException e) {
				// 网络错误
				status = 3;
			} finally {
				logger.info("调用接口状态：" + status);
			}

		}
		return body;
	}

	/**
	 * 解析返回的json内容，获取医生排班数据，返回有号源的医生列表
	 * hospitalId-医院ID
	 * deparmentId-科室ID
	 * count-获取数量
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
		JSONArray JsonArray = (JSONArray) json.get("appointmentDoctorEs"); // 拿到所有的医生排班数据

//		System.out.println(JsonArray.toString());
		for (int i = 0; i < JsonArray.length(); i++) {// 循环解析所有医生的排班数据
			String Info = "";
			String name = "";
			String departmentName = "";
			String doctorId = "";
			String date = "";
			String num = "";
			
			JSONObject Doctor = (JSONObject) JsonArray.get(i); // 获取单个医生的排班数据
			
			name = Doctor.getString("doctorName"); // 医生名称
			departmentName = Doctor.getString("departmentName"); // 科室名称
			doctorId = Doctor.getString("appointmentDoctorId"); // 医生ID
			
			JSONArray schedue = Doctor.getJSONArray("schedulingList"); // 排班信息
			for (int j = 0; j < schedue.length(); j++) {
				JSONObject tmp = (JSONObject) schedue.get(j);
				doctorIdList.add(doctorId);
				date += String.format("%s %s个号 %s ",
						tmp.getString("schedulingDate"),
						tmp.getString("schedulingCount"), " ");
			}
			Info = String.format("医生ID： %s %s %s %s %s ", doctorId,
					departmentName, name, date, num);
			System.out.println(Info);
		}
		return doctorIdList.get(new Random().nextInt(doctorIdList.size())); // 返回一个随机医生ID
	}
	
	

	public static void main(String[] args) throws Exception {
		GetDoctorScheduling ac = new GetDoctorScheduling(apiURL);
		ac.GetDoctorSchedule("588233786081144832","",20);
	}

	/**
	 * 0.成功 1.执行方法失败 2.协议错误 3.网络错误
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