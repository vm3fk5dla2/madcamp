package com.example.task1.Tab1;


import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.R;
import com.example.task1.Tab1.adapter.ContactAdapter;
import com.example.task1.Tab1.model.ContactList;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

  RecyclerView recyclerView;
  ContactAdapter adapter = new ContactAdapter();

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.layout_fragment1, container, false);

    recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    LoadContactsAsync lca = new LoadContactsAsync();
    lca.execute();
    return view;
  }

  class LoadContactsAsync extends AsyncTask<Void, Void, ArrayList<ContactList>> {
    ProgressDialog pd;

    @Override
    protected void onPreExecute() {
      // TODO Auto-generated method stub
      super.onPreExecute();

      pd = ProgressDialog.show(Fragment1.this.getContext(), "Loading Contacts", "Please Wait");
    }

    @Override
    protected ArrayList<ContactList> doInBackground(Void... params) {
      // TODO Auto-generated method stub
      ArrayList<ContactList> contacts = new ArrayList<>();
      Cursor c = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
      assert c != null;
      while (c.moveToNext()) {
        String contactName = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
        String phNumber = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        contacts.add(new ContactList("data:image/png;base64,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",
                contactName, phNumber, "KOREA"));
      }
      adapter.setItems(contacts);
      c.close();
      return contacts;
    }

    @Override
    protected void onPostExecute(ArrayList<ContactList> contacts) {
      // TODO Auto-generated method stub
      super.onPostExecute(contacts);

      pd.cancel();

      recyclerView.setAdapter(adapter);
    }
  }
}