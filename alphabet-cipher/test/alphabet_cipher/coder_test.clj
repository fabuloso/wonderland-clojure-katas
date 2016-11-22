(ns alphabet-cipher.coder-test
  (:require [clojure.test :refer :all]
            [alphabet-cipher.coder :refer :all]))

(deftest test-char-to-int
  (testing "given a number i wanna its letter"
    (is (= 97 (char-int \a))))
  )

(deftest test-int-to-char
  (testing "given a char i want its number"
  (is (= \a (int-char 97)))))

(deftest distance-between-two-letters
  (testing "i want to know the distance between two letters"
    (is (= 1 (distance \b)))))

(deftest cipher-a-with-b
  (testing "i want to cipher an a with a b"
    (is (= \b (cipher-single-char \a \b))))
    (is (= \e (cipher-single-char \s \m)))
    )

(deftest test-encode
  (testing "can encode given a secret keyword"
    (is (= "hmkbxebpxpmyllyrxiiqtoltfgzzv"
           (encode "vigilance" "meetmeontuesdayeveningatseven")))
    (is (= "egsgqwtahuiljgs"
           (encode "scones" "meetmebythetree")))))

(deftest test-decode
  (testing "can decode an cyrpted message given a secret keyword"
    (is (= "meetmeontuesdayeveningatseven"
           (decode "vigilance" "hmkbxebpxpmyllyrxiiqtoltfgzzv")))
    (is (= "meetmebythetree"
           (decode "scones" "egsgqwtahuiljgs")))))

(deftest test-decipher
  (testing "can extract the secret keyword given an encrypted message and the original message"
    (is (= "vigilance"
           (decipher "opkyfipmfmwcvqoklyhxywgeecpvhelzg" "thequickbrownfoxjumpsoveralazydog")))
    (is (= "scones"
           (decipher "hcqxqqtqljmlzhwiivgbsapaiwcenmyu" "packmyboxwithfivedozenliquorjugs")))))
