import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ChatMessageDto } from '../model/ChatMessageDto';
import { AdminService } from '../service/admin.service';
import { WebSocketService } from '../service/web-socket.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit, OnDestroy {


  user: any;
  email: any = localStorage.getItem('email')

  constructor(public webSocketService: WebSocketService, public as: AdminService) { }

  ngOnInit(): void {

    this.as.getUserByEmail(this.email).subscribe(res => {
      this.user = res;
    })

    this.webSocketService.openWebSocket();
  }

  ngOnDestroy(): void {
    this.webSocketService.closeWebSocket();
  }

  sendMessage(sendForm: NgForm) {
    const chatMessageDto = new ChatMessageDto(this.user, sendForm.value.message);
    this.webSocketService.sendMessage(chatMessageDto);
    sendForm.controls.message.reset();
  }

}
