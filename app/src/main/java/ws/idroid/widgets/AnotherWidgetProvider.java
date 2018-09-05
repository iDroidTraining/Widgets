package ws.idroid.widgets;

import android.app.PendingIntent;
import android.appwidget.*;
import android.content.*;
import android.net.Uri;
import android.widget.*;

public class AnotherWidgetProvider extends AppWidgetProvider {

    //1-AppWidgetProvider Java Class
    //2-XML Layout -Design for our widget
    //3-widget Provider XML - attributes to our widget
    //4-Receiver - in the manifest file

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int currentWidgetId : appWidgetIds) {
            String url = "https://www.idroid.ws";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));
            PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_another);
            views.setOnClickPendingIntent(R.id.button, pending);
            views.setTextViewText(R.id.textView,"Welcome!");
            appWidgetManager.updateAppWidget(currentWidgetId, views);
            Toast.makeText(context, "widget added!", Toast.LENGTH_LONG).show();
        }
    }
}
