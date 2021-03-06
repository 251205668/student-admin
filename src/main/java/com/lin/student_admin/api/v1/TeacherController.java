/**
 * @作者 努力中的杨先生
 * @描述 简要描述
 * @创建时间 2020-06-06 13:18
 */
package com.lin.student_admin.api.v1;

import com.lin.student_admin.dto.*;
import com.lin.student_admin.model.StudentUser;
import com.lin.student_admin.model.TeacherUser;
import com.lin.student_admin.repository.TeacherRepository;
import com.lin.student_admin.service.TeacherService;
import com.lin.student_admin.vo.ResponseTVo;
import com.lin.student_admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherRepository teacherRepository;

//    @PostMapping("/deleteIt")
//    public Map<String, Object>deleteit(@RequestParam Long id){
//        this.teacherRepository.deleteById(id);
//        Map<String, Object>data = new HashMap<>();
//        data.put("msg","删除成功");
//        data.put("code",200);
//        return data;
//    }
    // 教师登录
    @PostMapping("/login")
    public ResponseTVo Login(@RequestBody TeacherUserDto teacherUserDto){
        return new ResponseTVo("登录成功",200,teacherService.login(teacherUserDto.getName(),teacherUserDto.getPassword()));
    }

    // 教师注册
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody TeacherRegisterDto teacherRegisterDto){
        teacherService.register(teacherRegisterDto);
        Map<String, Object> data = new HashMap<>();
        data.put("code",200);
        data.put("msg","注册成功");
        return data;
    }

    // 删除一个教师信息

    @PostMapping("/delete")
    public Map<String, Object>delete(@RequestParam Long id){
        teacherService.deleteteacher(id);
        Map<String, Object>data = new HashMap<>();
        data.put("msg","删除成功");
        data.put("code",200);
        return data;
    }

    // 修改教师的信息

    @PostMapping("/modify")
    public Map<String, Object>modify(@RequestBody TeacherModifyDto teacherModifyDto){
        teacherService.modifyTeacherInfo(teacherModifyDto);
        Map<String, Object>data = new HashMap<>();
        data.put("msg","修改成功");
        data.put("code",200);
        return data;
    }

    // 获取一名教师信息

    @GetMapping("/getInfo")
    public ResponseVo getInfo(@RequestParam Long tno){
        return new ResponseVo(teacherService.getInfo(tno));
    }

    // 获取教师密码
    @PostMapping("/getPassword")
    public ResponseVo getPassword(@RequestParam String name){
        return new ResponseVo(teacherService.getTeacherPassword(name));
    }
}
