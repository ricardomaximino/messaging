import { Injectable, OnInit } from '@angular/core';
import * as SockJs from 'sockjs-client';
import * as Stomp from 'stompjs';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class ChatService {

  private socket;
  private stompClient;
  private messages: Message[] = [];
  private subscriptionsName: string[] = [];
  private subscriptionsObject: any[] = [];

  public _onTyping = new Subject<Message>();
  public _onMessageReceive = new Subject<Message>();
  public _onError = new Subject<any>();


  public connect(channel: string) {
    this.socket = SockJs('http://localhost:8080/ws');
    this.stompClient = Stomp.over(this.socket);
    this.subscriptionsObject.push(this.stompClient.connect({}, frame => this.onConnect(frame, channel), error => this.onError(error)));
  }

  public sendPrivate(message: Message) {
    this.stompClient.send('/app/chat.sendPrivateMessage', {}, JSON.stringify(message));
  }

  public sendMessage(message: Message) {
    this.stompClient.send('/app/chat.sendMessage', {}, JSON.stringify(message));
  }

  public sendTypingMessage(message: Message) {
    this.stompClient.send('/topic/typing', {}, JSON.stringify(message));
  }

  private addUser(message: Message) {
    this.stompClient.send('/app/chat.addUser', {}, JSON.stringify(message));
  }

  public disconnect() {
    /* for (let sub of this.subscriptionsObject) {
          sub.disconnect();
    } */
  }

  private onConnect(frame, channel) {
    const subscription = '/topic/' + channel;
    console.log('Subscription on channel => ' +  subscription);
    this.subscriptionsName.push(subscription);
    this.stompClient.subscribe( subscription, message => { this.onMessageReceived(message);  });
    this.stompClient.subscribe( '/topic/typing', message => { this.onTyping(message);  });
  }

// Receiving

  private onError(error) {
    this._onError.next(JSON.parse(error));
  }

  private onMessageReceived( message ) {
    this._onMessageReceive.next(JSON.parse(message.body));
  }

  private onTyping( message ) {
    this._onTyping.next(JSON.parse(message.body));
  }

}

export interface Message {
  type: string;
  sender: string;
  content: string;
}
