package com.example.whtsapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whtsapp.Models.MessageModel;
import com.example.whtsapp.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter {

    ArrayList<MessageModel>messageModels;
    Context context;
int SENDER_VIEW_TYPE=1;
int RECIEVER_VIEW_TYPE=2;


    public ChatAdapter(ArrayList<MessageModel> messageModels, Context context) {
        this.messageModels = messageModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==SENDER_VIEW_TYPE)
        {
            View view= LayoutInflater.from(context).inflate(R.layout.sample_sender,parent,false);
            return new SenderViewModel(view);
        }
        else
        {
            View view= LayoutInflater.from(context).inflate(R.layout.sample_reciever,parent,false);
            return new RecieverViewModel(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(messageModels.get(position).getuId().equals(FirebaseAuth.getInstance().getUid()))
        {
            return SENDER_VIEW_TYPE;
        }
        else
        {
            return RECIEVER_VIEW_TYPE;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

  MessageModel messageModel= messageModels.get(position);
  if(holder.getClass()==SenderViewModel.class)
  {
      ((SenderViewModel)holder).senderMsg.setText(messageModel.getMessage());
  }
  else
  {
      ((RecieverViewModel)holder).recieverMsg.setText(messageModel.getMessage());
  }
    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    public class RecieverViewModel extends RecyclerView.ViewHolder {
        TextView recieverMsg,recieverTime;
        public RecieverViewModel(@NonNull View itemView) {
            super(itemView);
            recieverMsg= itemView.findViewById(R.id.recieverText);
            recieverTime= itemView.findViewById(R.id.recieverTime);
        }
    }
    public class SenderViewModel extends  RecyclerView.ViewHolder {
        TextView senderMsg,senderTime;
        public SenderViewModel(@NonNull View itemView) {
            super(itemView);
            senderMsg= itemView.findViewById(R.id.senderText);
            senderTime= itemView.findViewById(R.id.senderTime);
        }
    }
}
