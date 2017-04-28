package com.websocket.demo;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;


public class WebSocketDemo {
	
	public static void f1() {
		try {
			
			WebSocketContainer container = ContainerProvider
					.getWebSocketContainer(); // 获取WebSocket连接器，其中具体实现可以参照websocket-api.jar的源码,Class.forName("org.apache.tomcat.websocket.WsWebSocketContainer");
			String uri = "wss://wenzhen.hk515.com/patientSocket/sockjs/patient?token=D0850CE333CE49D89DAF2DABE8F46370&userId=hk515132132132132";
			   Session session = container.connectToServer(Client.class, new URI(uri)); // 连接会话
			  session.getBasicRemote().sendText("{\"action\":\"patientQueueManager\",\"patientCode\":\"hk515132132132132\"}"); // 发送文本消息 {\\\"action\\\":\\\"patientQueueManager\\\",\\\"patientCode\\\":\\\"hk515{id2}{id3}\\\"}
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
