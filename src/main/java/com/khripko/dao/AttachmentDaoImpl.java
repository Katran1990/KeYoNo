package com.khripko.dao;

import com.khripko.model.Attachment;
import org.springframework.stereotype.Repository;

@Repository
public class AttachmentDaoImpl extends AbstractDao<Attachment>{
    public AttachmentDaoImpl(Class<Attachment> attachmentClass) {
        super(attachmentClass);
    }
}
