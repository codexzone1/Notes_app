package com.example.notes.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import com.example.notes.async.DeleteAsyncTask;
import com.example.notes.async.InsertAsyncTask;
import com.example.notes.async.UpdateAsyncTask;
import com.example.notes.models.Note;

public class NoteRepository {

    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context) {
        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNoteTask(Note note){
        new InsertAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }

    public void updateNoteTask(Note note){
        new UpdateAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }

    public LiveData<List<Note>> retrieveNotesTask() {

        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNoteTask(Note note){
        new DeleteAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }
}
