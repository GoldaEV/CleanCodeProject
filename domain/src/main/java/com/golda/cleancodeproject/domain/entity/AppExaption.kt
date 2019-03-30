package com.golda.cleancodeproject.domain.entity

import com.golda.cleancodeproject.domain.entity.vehicle.ExaptionType

class AppExaption(val type: ExaptionType = ExaptionType.UNKNOWN) : Throwable()