(ns passphrase.core
  (:gen-class))

(def secure-random (new java.security.SecureRandom))

(defn secure-rand-nth
  "rand-nth using SecureRandom"
  [coll]
  (let [n (count coll)]
    (nth coll (Math/floor (* n (.nextFloat secure-random))))))

(defn entropy-per-word
  "Calculate entropy per word from wordlist size"
  [n]
  (int (/ (Math/log n) (Math/log 2))))

(defn list-from-file
  "Take a file name and return wordlist, sanitized and shuffled"
  [file]
  (->> file
   (slurp)
   (clojure.string/split-lines)
   (filter #(re-matches #"^[a-z]*$" %))
   (distinct)))

(defn pick-from-list
  "Pick n random elements from coll, repeats allowed"
  [n coll]
  (loop [list '()
         n n
         coll coll]
    (if (= n 0)
      list
      (recur (conj list (secure-rand-nth coll)) (dec n) coll))))

(defn -main
  "Generate passphrase from wordlist"
  [& args]
  (let [length 8
        filename "/usr/share/dict/words"
        words (list-from-file filename)]
    (println (pick-from-list length words))
    (println "Minumum of"
             (entropy-per-word (count words))
             "bits of entropy per word")))

