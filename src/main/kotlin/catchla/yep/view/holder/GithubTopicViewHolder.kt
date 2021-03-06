package catchla.yep.view.holder

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.view.View
import catchla.yep.R
import catchla.yep.adapter.TopicsAdapter
import catchla.yep.model.GithubAttachment
import catchla.yep.model.Topic
import catchla.yep.util.ImageLoaderWrapper
import catchla.yep.util.Utils
import catchla.yep.util.view.ViewSupport
import kotlinx.android.synthetic.main.layout_topic_attachment_github.view.*

/**
 * Created by mariotaku on 15/12/9.
 */
class GithubTopicViewHolder(
        topicsAdapter: TopicsAdapter,
        itemView: View,
        context: Context,
        imageLoader: ImageLoaderWrapper,
        listener: TopicsAdapter.TopicClickListener?
) : TopicViewHolder(topicsAdapter, itemView, context, imageLoader, listener) {

    private val attachmentView by lazy { itemView.attachmentView }
    private val repoName by lazy { itemView.repoName }
    private val repoDescription by lazy { itemView.repoDescription }

    init {
        attachmentView.setOnClickListener(this)
        ViewSupport.setClipToOutline(attachmentView, true)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.attachmentView -> {
                val attachment = adapter.getTopic(layoutPosition).attachments[0] as GithubAttachment
                Utils.openUri(adapter.context as Activity, Uri.parse(attachment.url))
                return
            }
        }
        super.onClick(v)
    }

    override fun displayTopic(topic: Topic, highlight: String?) {
        super.displayTopic(topic, highlight)
        val attachment = topic.attachments[0] as GithubAttachment
        repoName.text = attachment.name
        repoDescription.text = attachment.description
    }
}
