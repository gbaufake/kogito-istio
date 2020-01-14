QUAY_USER ?= kvarela
QUAY_REPO ?= quay.io/${QUAY_USER}/kogito-istio

create-v1-native-image:
	 mvn package -Pnative -Dquarkus.native.container-build=true&& docker build -f src/main/docker/native/Dockerfile -t ${QUAY_REPO}:v1 .

create-v1-jvm-image:
         mvn package && docker build -f src/main/docker/jvm/Dockerfile -t ${QUAY_REPO}:v1 .

push-v1-image:
	docker push quay.io/gbaufake/kogito-istio:v1


deploy-kogito-istio:
	oc new-project kogito-istio
	oc project kogito-istio
	oc create -f src/main/kubernetes/service.yaml
	oc create -f src/main/kubernetes/deployment.yaml

deploy-istio-gateway:
	ansible-playbook src/main/kubernetes/ansible/quarkus.yml -e '{"quarkus": {"namespace": "kogito-istio", "control_plane_namespace": "istio-system"}}' -v
