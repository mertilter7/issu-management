package com.temelt.issuemanagement.implement;

import com.temelt.issuemanagement.entity.IssueHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.temelt.issuemanagement.repository.IssueHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository  issueHistoryRepository;

    @Autowired
    public IssueHistoryServiceImpl (IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }



    public IssueHistory save(IssueHistory issueHistory) {

        if (issueHistory.getDate() == null) {
            throw new IllegalArgumentException("Issue cannot be null");
        }
        issueHistory = issueHistoryRepository.save(issueHistory);
        return issueHistory;
    }

    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    public Page<IssueHistory> getAllPageable(Pageable pageable) {

        return issueHistoryRepository.findAll(pageable);
    }
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
