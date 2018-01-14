# passphrase

Takes a wordlist and randomly generates an 8 word phrase from it. It then provides an estimate of the minimum entropy per word.

This is the entropy per word that a secure random shuffling would produce. Even if an assailant gives you a pre-cooked wordlist passphrase filters it for repeated words. And this entropy minimum is still valid **so long as Java's SecureRandom prng is secure**.

Using the default /usr/share/dict/words list on my Fedora 27 I get >18 bits per word making a full 8 word phrase >144 bits of entropy.

If an assailant tampers your wordlist successfully then entropy per word will fall.

Passphrase makes use of your wordlist to produce easily communicated passwords.

## So should I use this everywhere?

I can't recommend that you do. Since security is so important but... I personally do but the caveats are that your computer can generate random numbers (same with any password generator).

Security here comes down to the SecureRandom function in Java which is designed to be cryptographically secure.

## Installation

Latest version is always on [GitHub](https://github.com/wolfmankurd/passphrase).

[Releases](https://github.com/wolfmankurd/passphrase/releases)

## Usage

Make sure you have a wordlist at /usr/share/dict/words

```
$ java -jar passphrase-0.2.0-standalone.jar
```

## Building

Uses [Leiningen](https://leiningen.org/)

```
$ git clone git@github.com:wolfmankurd/passphrase.git
$ cd passphrase
$ lein uberjar
```

Jar file will be in ./target/uberjar/ You want the "-standalone" file.

## Todo

* Make sure rand-nth is secure
* Make it take command line arguments, password length, wordlist path, verbosity.

## License

Copyright © 2018 Ali Raheem

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
