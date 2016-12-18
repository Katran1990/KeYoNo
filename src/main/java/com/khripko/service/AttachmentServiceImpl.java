package com.khripko.service;

import com.khripko.dao.AttachmentDao;
import com.khripko.dao.GenericDao;
import com.khripko.model.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AttachmentServiceImpl extends GenericServiceImpl<Attachment, Long> implements AttachmentService {

    private AttachmentDao dao;

    public AttachmentServiceImpl() {
    }

    @Autowired
    public AttachmentServiceImpl(@Qualifier("attachmentDaoImpl")GenericDao<Attachment, Long> genericDao) {
        super(genericDao);
        this.dao = (AttachmentDao) genericDao;
    }
}
