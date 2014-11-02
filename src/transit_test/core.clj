(ns transit-test.core
  (:require [cognitect.transit :as transit])
  (:import [java.io ByteArrayInputStream ByteArrayOutputStream]))

;; Write data to a stream
(def out (ByteArrayOutputStream. 4096))
(def writer (transit/writer out :msgpack))
(transit/write writer 12345)

;; Take a peek at the JSON
(.toString out)

;; Read data from a stream
(def in (ByteArrayInputStream. (.toByteArray out)))
(def reader (transit/reader in :msgpack))
(def result (transit/read reader))
(prn result)