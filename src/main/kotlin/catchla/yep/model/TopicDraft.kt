package catchla.yep.model

/**
 * Created by mariotaku on 16/8/25.
 */
data class TopicDraft(
        var text: String,
        @Topic.Kind var kind: String? = null,
        var attachment: String? = null
) {


}
