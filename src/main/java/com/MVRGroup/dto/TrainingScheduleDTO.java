package com.MVRGroup.dto;
import lombok.Data;

@Data
public class TrainingScheduleDTO {

 
    private int trainingscheduleid;

    private int trainingid;

    private String startDate;
    

    private String endDate;

    private String timings;
    
    private String trainingname;
    
    private String description;

	public TrainingScheduleDTO(int trainingscheduleid, int trainingid, String startDate, String endDate, String timings,
			String trainingname, String description) {
		super();
		this.trainingscheduleid = trainingscheduleid;
		this.trainingid = trainingid;
		this.startDate = startDate;
		this.endDate = endDate;
		this.timings = timings;
		this.trainingname = trainingname;
		this.description = description;
	}

	public TrainingScheduleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


    
    
}
  