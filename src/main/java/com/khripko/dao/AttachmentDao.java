package com.khripko.dao;

import com.khripko.model.Attachment;

public interface AttachmentDao {

    void create(Attachment entity);
    Attachment read(Long id);
    Attachment update(Attachment entity);
    void delete(Attachment entity);

}
