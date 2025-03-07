FROM --platform=linux/amd64 ubuntu:20.04

# Some params
ARG USERNAME=me
ARG USER_UID=1000
ARG USER_GID=$USER_UID

# Making apt not ask questions
ENV DEBIAN_FRONTEND=noninteractive
ENV DEBCONF_NONINTERACTIVE_SEEN=true
# Updating system and installing required dependencies
RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install -y build-essential git
RUN apt-get install -y openjdk-17-jre-headless maven
RUN rm -rf /var/lib/apt/lists/*

# Creating user
RUN groupadd --gid $USER_GID $USERNAME \
    && useradd --uid $USER_UID --gid $USER_GID -m $USERNAME -s /bin/bash
# Switching default user
USER $USERNAME
