package com.websocket.demo;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;


public class WebSocketDemo {
	
	public static void f1() {
		try {
			
			WebSocketContainer container = ContainerProvider
					.getWebSocketContainer(); // ��ȡWebSocket�����������о���ʵ�ֿ��Բ���websocket-api.jar��Դ��,Class.forName("org.apache.tomcat.websocket.WsWebSocketContainer");
			String uri = "wss://wenzhen.hk515.com/patientSocket/sockjs/patient?token=D0850CE333CE49D89DAF2DABE8F46370&userId=hk515132132132132";
			   Session session = container.connectToServer(Client.class, new URI(uri)); // ���ӻỰ
			  session.getBasicRemote().sendText("{\"action\":\"patientQueueManager\",\"patientCode\":\"hk515132132132132\"}"); // �����ı���Ϣ {\\\"action\\\":\\\"patientQueueManager\\\",\\\"patientCode\\\":\\\"hk515{id2}{id3}\\\"}
//			  session.getBasicRemote().sendText("4564546");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();
	}

}
