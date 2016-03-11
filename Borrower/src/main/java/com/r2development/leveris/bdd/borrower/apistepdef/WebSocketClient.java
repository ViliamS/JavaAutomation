package com.r2development.leveris.bdd.borrower.apistepdef;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@ClientEndpoint
public class WebSocketClient {

    protected WebSocketContainer container;
    protected Session userSession = null;
//    protected Session onOpenSession = null;

    public WebSocketClient() {
        container = ContainerProvider.getWebSocketContainer();
    }

    public void Connect(String sServer) {

        try {
            userSession = container.connectToServer(this, new URI(sServer));

        } catch (DeploymentException | URISyntaxException | IOException e) {
            e.printStackTrace();
        }

    }

    public void SendMessage(String sMsg) throws IOException {
        userSession.getBasicRemote().sendText(sMsg);
    }

    @OnOpen
    public void onOpen(Session session) {
//        log.info("WebSocket Connected");
//        onOpenSession = session;
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
    }

    @OnMessage
    public void onMessage(Session session, String msg) {
        System.out.println(msg);
    }

    public void Disconnect() throws IOException {
        userSession.close();
    }
}