/**
 * @作者 努力中的杨先生
 * @描述 简要描述
 * @创建时间 2020-06-06 14:28
 */
package com.lin.student_admin.repository;

import com.lin.student_admin.model.StudentUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentUser,Long> {

    StudentUser findOneBySno(Long sno);
    StudentUser findOneById(Long id);

    // 登录判断

    Long countByUsernameAndPassword(String username,String password);
    StudentUser findOneByUsername(String username);

    // sno删除

    void deleteAllBySno(Long sno);

    // 搜索

    Page<StudentUser> findByNameContainingOrSubjectContainingOrCollegeContaining(String keyword1, String keyword2, String keyword3, Pageable pagable);

}
