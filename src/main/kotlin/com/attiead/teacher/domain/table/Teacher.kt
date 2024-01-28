package com.attiead.teacher.domain.table

import com.attiead.teacher.common.entity.BaseEntity
import com.attiead.teacher.domain.vo.GraduateStatus
import com.attiead.teacher.domain.vo.Location
import com.attiead.teacher.domain.vo.Major
import com.attiead.teacher.domain.vo.Subject
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "teachers")
class Teacher(
    @Column(name = "uid")
    val uid: String,

    @Column(name = "tid")
    val tid: String = UUID.randomUUID().toString(),

    @Column(name = "profile_image_file_path")
    val profileImageFilePath: String? = null,

    @Column(name = "university")
    val university: String,

    @Column(name = "major")
    @Enumerated(EnumType.STRING)
    val major: Major = Major.ETC,

    @Column(name = "subject")
    @Enumerated(EnumType.STRING)
    val subject: Subject = Subject.ETC,

    @Column(name = "graduate_status")
    @Enumerated(EnumType.STRING)
    val graduateStatus: GraduateStatus = GraduateStatus.GRADUATED,

    @Column(name = "portfolio_file_path")
    val portfolioFilePath: String? = null,

    @Column(name = "introduce")
    val introduce: String? = null,

    @Column(name = "career")
    val career: Int = 0,

    @Column(name = "location")
    @Enumerated(EnumType.STRING)
    val location: Location = Location.SEOUL,

    @Column(name = "percent_of_completion")
    var percentOfCompletion: Int = 6,

) : BaseEntity() {
}
