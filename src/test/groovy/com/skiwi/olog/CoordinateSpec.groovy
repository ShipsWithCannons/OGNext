package com.skiwi.olog

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Coordinate)
class CoordinateSpec extends Specification {
    def setup() {
    }

    def cleanup() {
    }

    void "save coordinates"() {
        expect:
        new Coordinate(galaxy: 2, solarSystem: 122, position: 12).save(failOnError: false)

        new Coordinate(galaxy: 1, solarSystem: 1, position: 1).save(failOnError: false)
        new Coordinate(galaxy: 9, solarSystem: 1, position: 1).save(failOnError: false)
        new Coordinate(galaxy: 1, solarSystem: 499, position: 1).save(failOnError: false)
        new Coordinate(galaxy: 1, solarSystem: 1, position: 15).save(failOnError: false)

        !new Coordinate(galaxy: 0, solarSystem: 122, position: 12).save(failOnError: false)
        !new Coordinate(galaxy: 10, solarSystem: 122, position: 12).save(failOnError: false)
        !new Coordinate(galaxy: 2, solarSystem: 0, position: 12).save(failOnError: false)
        !new Coordinate(galaxy: 2, solarSystem: 500, position: 12).save(failOnError: false)
        !new Coordinate(galaxy: 2, solarSystem: 122, position: 0).save(failOnError: false)
        !new Coordinate(galaxy: 2, solarSystem: 122, position: 16).save(failOnError: false)
    }
}