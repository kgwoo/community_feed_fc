package com.gunoo.service.post.domain.content;

import com.gunoo.service.post.domain.common.DatetimeInfo;

public abstract class Content {

    String contentText;
    final DatetimeInfo datetimeInfo;

    public Content(String contentText) {
        checkText(contentText);
        this.contentText = contentText;
        this.datetimeInfo = new DatetimeInfo();
    }

    public void updateContent(String updateContent) {
        checkText(updateContent);
        this.contentText = updateContent;
        this.datetimeInfo.updateEditDateTime();
    }

    protected abstract void checkText(String contentText);

    public String getContentText() {
        return contentText;
    }
}
