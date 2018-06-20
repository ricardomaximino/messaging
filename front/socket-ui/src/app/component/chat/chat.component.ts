import { Component, OnInit, ViewChild } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { ChatService, Message } from '../chat.service';


@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],
  providers: [ChatService]
})
export class ChatComponent implements OnInit {
  @ViewChild('chat') chat;
  @ViewChild('username') username;
  @ViewChild('message') message;
  public typing;
  private socket;
  private stompClient;
  public errors: any[] = [];
  private messages: Message[] = [];
  public typingMessage: Message;

  constructor(private chartService: ChatService) { }

  ngOnInit() {
    this.chartService._onError.subscribe(error => this.errors.push(error));
    this.chartService._onMessageReceive.subscribe(data => {
      this.typingMessage = null;
      this.messages.push(data);
    });
    this.chartService._onTyping.subscribe(data => this.typingMessage = data);
  }

  public connect() {
    const message = this.getMessage();
    console.log(message);
    this.chartService.connect(message.type);
  }

  public sendMessage() {
    this.chartService.sendMessage(this.getMessage());
  }

  public sendPrivate() {
    this.chartService.sendPrivate(this.getMessage());
  }

  public sendTypingMessage() {
    this.chartService.sendTypingMessage(this.getMessage());
  }

  public disconnect() {
    this.chartService.disconnect()
  }

  private getMessage(): Message {
    return {
      type: this.chat.nativeElement.value,
      content: this.message.nativeElement.value,
      sender: this.username.nativeElement.value
    };
  }

}
