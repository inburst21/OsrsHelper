package inburst.com.osrshelper.Tools.Mappers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import inburst.com.osrshelper.Responses.Summary;

/**
 * lennyhicks
 * 9/6/18
 */
public class SummaryMapper extends BaseMapper<JsonObject, Summary> {
    @Override
    public Summary from(JsonObject entity) {
        Gson gson = new Gson();
        return gson.fromJson(entity, Summary.class);
    }
}
