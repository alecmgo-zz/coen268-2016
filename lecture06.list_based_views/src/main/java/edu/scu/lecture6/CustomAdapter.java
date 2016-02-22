package edu.scu.lecture6;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Person> {

    private final List<Person> people;

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    public CustomAdapter(Context context, int resource, List<Person> people) {
        super(context, resource, people);
        this.people = people;
    }

    // getDropDownView returns the view for the dropdown. We use the same view
    // between getView and getDropDownView.
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person person = people.get(position);

        View row;
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.custom_row, null);

            holder = new ViewHolder();
            holder.imageView = (ImageView) row.findViewById(R.id.rowImage);
            holder.textView = (TextView) row.findViewById(R.id.rowText);
            row.setTag(holder);
        } else {
            row = convertView;
            holder = (ViewHolder) row.getTag();
        }

        // Set the text
        holder.textView.setText(person.getName());

        // Set the image
        try {
            InputStream inputStream = getContext().getAssets().open(person.getFilename());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            holder.imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }
}


