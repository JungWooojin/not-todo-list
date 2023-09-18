package com.green.nottodolist.monthlyGoal;

import com.green.nottodolist.monthlyGoal.model.MonthlyGoalDetailVo;
import com.green.nottodolist.monthlyGoal.model.MonthlyGoalInsDto;
import com.green.nottodolist.monthlyGoal.model.MonthlyGoalUpdDto;
import com.green.nottodolist.monthlyGoal.model.MonthlyGoalVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monthly-goal")
@RequiredArgsConstructor
@Tag(name = "2. 월간 목표 설정")
public class MonthlyGoalController {
    private final MonthlyGoalService service;

    @PostMapping
    @Operation(summary = "월간 목표 추가", description = "" +
            "memberId: [int] 회원 id<br>" +
            "notTodo: [최대 20자] 절제할 항목(ex 담배, 술)<br>" +
            "costCategory: 비용구분(돈, 시간)<br>" +
            "goalCost: [int] 목표비용,<br>" +
            "monthYear: [최대 7자] 년월(ex 2023-06)<br>")
    public int postMonthlyGoal(@RequestBody MonthlyGoalInsDto dto) {
        return service.insMonthlyGoal(dto);
    }

    @PutMapping
    @Operation(summary = "월간 목표 수정", description = "" +
            "goalId: [int] 수정할 목표 id값<br>" +
            "goalCost: [int] 목표비용<br>")
    public int putMonthlyGoal(@RequestBody MonthlyGoalUpdDto dto) {
        return service.updMonthlyGoal(dto);
    }

    @DeleteMapping
    @Operation(summary = "월간 목표 삭제", description = "" +
            "goalId: [int] 삭제할 목표 id값")
    public int delMonthlyGoal(@RequestParam int goalId) {
        return service.delMonthlyGoal(goalId);
    }

    @GetMapping
    @Operation(summary = "월간 목표 조회")
    public List<MonthlyGoalDetailVo> getMonthlyGoal(int memberId) {
        return service.selMonthlyGoalAll(memberId);
    }
}
