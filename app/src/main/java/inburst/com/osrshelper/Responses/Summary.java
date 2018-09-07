package inburst.com.osrshelper.Responses;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;

import inburst.com.osrshelper.Entity.EntityItem;

/**
 * lennyhicks
 * 9/4/18
 */
@JsonAdapter(Summary.SummaryJsonAdapter.class)
public class Summary {
    private ArrayList<EntityItem> items;

    public ArrayList<EntityItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<EntityItem> items) {
        this.items = items;
    }

    public static class SummaryJsonAdapter extends TypeAdapter<Summary> {

        @Override
        public void write(JsonWriter out, Summary value) throws IOException {

        }

        @Override
        public Summary read(JsonReader reader) throws IOException {
            ArrayList<EntityItem> items = new ArrayList<>();
            Gson gson = new Gson();
            reader.beginObject();
            while (reader.hasNext()) {
                reader.nextName(); // Read "42", "365", ...
                EntityItem item = gson.fromJson(reader, EntityItem.class);
                if(item.getSellAverage() != 0 && item.getBuyAverage() != 0)
                items.add(item);
            }
            reader.endObject();

            Summary data = new Summary();
            // Can probably be simplified
            data.setItems(items);

            return data;
        }
    }
}
