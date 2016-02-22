package edu.scu.coen268.lecture22widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class ExampleAppWidgetProvider extends AppWidgetProvider {
    private static int counter = 0;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int appWidgetId : appWidgetIds) {
            // Create a pending intent
            Intent intent = new Intent(context, ExampleAppWidgetProvider.class);
            intent.setAction("edu.scu.INCREMENT_COUNT");
            intent.putExtra("appWidgetId", appWidgetId);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent,
                    PendingIntent.FLAG_CANCEL_CURRENT);

            // Set the view
            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.example_appwidget);
            views.setOnClickPendingIntent(R.id.widget_text, pendingIntent);
            views.setTextViewText(R.id.widget_text, "Count: " + counter);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent.getAction().equals("edu.scu.INCREMENT_COUNT")) {
            counter++;
            int appWidgetId = intent.getIntExtra("appWidgetId", -1);

            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.example_appwidget);
            views.setTextViewText(R.id.widget_text, "Count: " + counter);

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}

