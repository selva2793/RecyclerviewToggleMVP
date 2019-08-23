package com.selvamani.recyclerviewmvp.Remote.Deserializers;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.selvamani.recyclerviewmvp.Remote.Datamodel.ChildModel;
import java.lang.reflect.Type;


public class ChildModelDeserializer implements JsonDeserializer<ChildModel> {

@Override
public ChildModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
final JsonObject jsonObject=json.getAsJsonObject();
        ChildModel childModel=new ChildModel();


        if (jsonObject.get("_id") != null) {
        if(!jsonObject.get("_id").isJsonNull()) {
            childModel.setId(jsonObject.get("_id").getAsInt());
        }else {
            childModel.setId(0);
        }
        }
        else {
            childModel.setId(0);
        }

        return childModel;

        }

   }

