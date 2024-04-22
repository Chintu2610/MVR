package com.MVRGroup.dto;

import com.MVRGroup.entity.WorkAssign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkAssignDTO {
	private int id;
    private String email;
    private String assignedWork;
    private int userId;
    private String Name;
    private String status;// Add more user properties as needed

    public WorkAssignDTO(WorkAssign workAssign) {
        this.id = workAssign.getWorkid();
        this.email = workAssign.getEmail();
        this.assignedWork = workAssign.getAssignedWork();
        this.userId = workAssign.getUser().getUserid();// Assuming User has an id field
        this.Name = workAssign.getUser().getName() ;
        this.status=workAssign.getStatus();// Assuming User has a firstName field
    }
}
