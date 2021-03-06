package catchla.yep.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

import catchla.yep.model.util.InstagramImageConverter;

/**
 * Created by mariotaku on 15/6/4.
 */
@JsonObject
public class InstagramMedia {

    @JsonField(name = "id")
    private String id;
    @JsonField(name = "images", typeConverter = InstagramImageConverter.class)
    private List<InstagramImage> images;
    @JsonField(name = "link")
    private String link;
    @JsonField(name = "type")
    private String type;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<InstagramImage> getImages() {
        return images;
    }

    public void setImages(final List<InstagramImage> images) {
        this.images = images;
    }

    public String getLink() {
        return link;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }
}
