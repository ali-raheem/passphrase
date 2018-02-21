(ns passphrase.core-test
  (:require [clojure.test :refer :all]
            [passphrase.core :refer :all]))

(deftest entropy-per-word-test
  (testing "entropy-per-word"
    (is (= (entropy-per-word 2) 1))
    (is (= (entropy-per-word 5) 2))
    (is (= (entropy-per-word 10) 3))))

(deftest pick-from-list-test
  (testing "entropy-per-word"
    (let [coll '("hello" "test" "bye")]
      (is (= (count (pick-from-list 1 coll)) 1))
      (is (= (count (pick-from-list 2 coll)) 2))
      (is (= (count (pick-from-list 3 coll)) 3))
      (is (= (count (pick-from-list 10 coll)) 10)))))
