package com.example.lazy.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lazy on 8/28/2016.
 */
public class ContactAdaptor extends ArrayAdapter{
    List list = new ArrayList();
    public ContactAdaptor(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        ContactHolder contactHolder;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_ID = (TextView)row.findViewById(R.id.txID);
            contactHolder.tx_Num = (TextView)row.findViewById(R.id.txNum);
            contactHolder.tx_Lic = (TextView)row.findViewById(R.id.txLic);
            contactHolder.tx_Loc = (TextView)row.findViewById(R.id.txLoc);
            contactHolder.tx_BB = (TextView)row.findViewById(R.id.txBB);
            contactHolder.tx_Model = (TextView)row.findViewById(R.id.txModel);
            contactHolder.tx_Comm = (TextView)row.findViewById(R.id.txComm);
            contactHolder.tx_MaPaSe = (TextView)row.findViewById(R.id.txMaPaSe);
            contactHolder.tx_Date = (TextView)row.findViewById(R.id.txDate);

            row.setTag(contactHolder);
        }
        else{
            contactHolder = (ContactHolder)row.getTag();
        }
        Contacts contacts = (Contacts)this.getItem(position);
        contactHolder.tx_ID.setText(contacts.getID());
        contactHolder.tx_Num.setText(contacts.getNum());
        contactHolder.tx_Lic.setText(contacts.getLic());
        contactHolder.tx_Loc.setText(contacts.getLoc());
        contactHolder.tx_BB.setText(contacts.getBB());
        contactHolder.tx_Model.setText(contacts.getModel());
        contactHolder.tx_Comm.setText(contacts.getComm());
        contactHolder.tx_MaPaSe.setText(contacts.getMaPaSe());
        contactHolder.tx_Date.setText(contacts.getDate());
        return row;
    }
    static class ContactHolder{
        TextView tx_ID, tx_Num, tx_Lic, tx_Loc, tx_BB, tx_Model, tx_Comm, tx_MaPaSe, tx_Date;
    }
}
