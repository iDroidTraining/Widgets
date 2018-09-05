package ws.idroid.widgets;

import android.app.PendingIntent;
import android.appwidget.*;
import android.content.*;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

public class MyWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        ComponentName thisWidget = new ComponentName(context, MyWidgetProvider.class);

        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

        for (int widgetId : allWidgetIds) {
            int number = (new Random().nextInt(100));
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout
                    .widget_my);
            Log.i("Widget number", String.valueOf(number));
            remoteViews.setTextViewText(R.id.update, String.valueOf(number));

            //Intent
            Intent intent = new Intent(context, MyWidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);

            appWidgetManager.updateAppWidget(widgetId, remoteViews);

        }

    }
}
