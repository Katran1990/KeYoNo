package com.khripko.dao;

import com.khripko.model.Attachment;

public interface AttachmentDao {

    void create(Attachment entity);
    Attachment read(Long id);
    Attachment update(Long id);
    void delete(Long id);

}
