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

    @Column(name = "profileImagePath")
    val profileImagePath: String? = null,

    @Column(name = "university")
    val university: String,

    @Column(name = "major")
    val major: Major = Major.ETC,

    @Enumerated(EnumType.STRING)
    val subject: Subject = Subject.ETC,

    @Enumerated(EnumType.STRING)
    val graduateStatus: GraduateStatus = GraduateStatus.GRADUATED,

    @Column(name = "portfolioPath")
    val portfolioPath: String? = null,

    @Column(name = "introduce")
    val introduce: String? = null,

    @Column(name = "career")
    val career: Int = 0,

    @Column(name = "location")
    val location: Location = Location.SEOUL,

    @Column(name = "percentOfCompletion")
    val percentOfCompletion: Int = 0,

) : BaseEntity() {

}
