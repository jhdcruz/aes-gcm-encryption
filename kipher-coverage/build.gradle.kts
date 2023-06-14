plugins {
    id("conventions.module")
    id("jacoco-report-aggregation")
}

dependencies {
    jacocoAggregation(projects.kipherCommon)
    jacocoAggregation(projects.kipherAes)
}

@Suppress("UnstableApiUsage")
reporting {
    reports {
        creating(JacocoCoverageReport::class) {
            testType.set(TestSuiteType.UNIT_TEST)
        }
    }
}

tasks {
    test {
        finalizedBy(testCodeCoverageReport)
    }
}
