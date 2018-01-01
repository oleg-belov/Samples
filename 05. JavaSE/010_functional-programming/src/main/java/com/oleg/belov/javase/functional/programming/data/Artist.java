package com.oleg.belov.javase.functional.programming.data;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public final class Artist {
    
    private String name;
    private List<Artist> members;
    private String nationality;
    
    public Artist(String name, String nationality) {
        this(name, Collections.emptyList(), nationality);
    }

    public Artist(String name, List<Artist> members, String nationality) {
        this.name = Objects.requireNonNull(name);
        this.members = Objects.requireNonNull(members);
        this.nationality = Objects.requireNonNull(nationality);
    }

    public String getName() {
        return name;
    }

    public Stream<Artist> getMembers() {
        return members.stream();
    }

    public String getNationality() {
        return nationality;
    }

    public boolean isSolo() {
        return members.isEmpty();
    }

    public boolean isFrom(String nationality) {
        return this.nationality.equals(nationality);
    }
    
    
    @Override
	public String toString() {
		return "Artist [name=" + name + ", members=" + members + ", nationality=" + nationality + "]";
	}

	public Artist copy() {
        List<Artist> members = getMembers().map(Artist::copy).collect(toList());
        return new Artist(name, members, nationality);
    }

}
