package com.temelt.issuemanagement.implement;

import com.temelt.issuemanagement.entity.Project;
import com.temelt.issuemanagement.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

private final ProjectRepository projectRepository;
public ProjectServiceImpl(ProjectRepository projectRepository) {

    this.projectRepository = projectRepository;
}


    public Project save(Project project) {
    if(project.getProjectCode() == null) {
        throw new IllegalArgumentException("Project Code cannot be null!");
    }
        return projectRepository.save(project);
    }

    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    public List<Project> getByProjectCode(String projectCode) {
        return projectRepository.getAllByProjectCode(projectCode);
    }

    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    public Boolean delete(Project project) {
        return null;
    }
}
