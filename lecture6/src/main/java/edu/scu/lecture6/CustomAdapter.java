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

    public CustomAdapter(Context context, int resource, List<Person> people) {
        super(context, resource, people);
        this.people = people;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person person = people.get(position);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_row, null);

        // Set the text
        TextView textView = (TextView) row.findViewById(R.id.rowText);
        textView.setText(person.getName());

        // Set the image
        try {
            ImageView imageView = (ImageView) row.findViewById(R.id.rowImage);
            InputStream inputStream = getContext().getAssets().open(person.getFilename());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }
}


