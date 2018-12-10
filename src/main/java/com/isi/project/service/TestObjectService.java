package com.isi.project.service;

import com.isi.project.entities.TestObject;
import com.isi.project.repository.TestObjectRepository;
import com.isi.project.repository.TestObjectSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;

@Service
public class TestObjectService {

    private TestObjectRepository testObjectRepository;
    private PagedResourcesAssembler pagedResourcesAssembler;

    public TestObjectService(TestObjectRepository testObjectRepository, PagedResourcesAssembler pagedResourcesAssembler) {
        this.testObjectRepository = testObjectRepository;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    public PagedResources<TestObject> hasNameLikeAndhasMiniObejctNameLike(
            @PageableDefault(page = 0, size = 10)Pageable pageable,
            String TOname,
            String MTOname) {
        Page<TestObject> testObjects = testObjectRepository.findAll(TestObjectSpecifications.hasNameLikeAndhasMiniObejctNameLike(TOname, MTOname), pageable);

        return pagedResourcesAssembler.toResource(testObjects);
    }
}
