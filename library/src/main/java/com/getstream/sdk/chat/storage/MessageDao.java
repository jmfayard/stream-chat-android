package com.getstream.sdk.chat.storage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.getstream.sdk.chat.rest.Message;

import java.util.List;


@Dao
public interface MessageDao {

    @Insert
    void insert(Message word);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMessages(List<Message> messages);


    @Query("SELECT * FROM stream_message " +
            "WHERE stream_message.cid = :cid ORDER by created_at ASC LIMIT :limit")
    List<Message> selectMessagesForChannel(final String cid, final Integer limit);

}